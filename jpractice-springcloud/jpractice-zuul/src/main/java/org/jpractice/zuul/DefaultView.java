/**
 * 
 */
package org.jpractice.zuul;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.util.PropertyPlaceholderHelper.PlaceholderResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.util.HtmlUtils;
/**
 * @author: 作者： chengaofeng
 * @date: 创建时间：2019-01-11 08:37:53
 * @Description: TODO
 * @version V1.0
 */
public class DefaultView implements View {
	public static DefaultView defaultErrorView = new DefaultView("<html>"
			+ "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\"/>"
			+ "<style type=\"text/css\">"
			+ "<!--"
			+ "body{margin:0;font-size:.7em;font-family:Verdana, Arial, Helvetica, sans-serif;background:#EEEEEE;}"
			+ "fieldset{padding:0 15px 10px 15px;} "
			+ "h1{font-size:2.4em;margin:0;color:#FFF;}"
			+ "h2{font-size:1.7em;margin:0;color:#CC0000;} "
			+ "h3{font-size:1.2em;margin:10px 0 0 0;color:#000000;} "
			+ "#header{width:96%;margin:0 0 0 0;padding:6px 2% 6px 2%;font-family:\"trebuchet MS\", Verdana, sans-serif;color:#FFF;"
			+ "background-color:#555555;}" + "#content{margin:0 0 0 2%;position:relative;}"
			+ ".content-container{background:#FFF;width:96%;margin-top:8px;padding:10px;position:relative;}"
			+ "-->"
			+ "</style>"
			+ "<body><div id=\"header\"><h1>服务器错误</h1></div>"
			+"<div id=\"content\">"
			+ "<div class=\"content-container\"><fieldset>"
            + " <h2>${error} - ${status}内部服务器错误。${message}</h2>"
			+ " <h3>您查找的资源存在问题，因而无法显示。</h3>"
			+ " </fieldset></div>"
			+ "</div>" + "</body></html>");

	private final String template;

    private final NonRecursivePropertyPlaceholderHelper helper;

    private volatile Map<String, Expression> expressions;

	private DefaultView(String template) {
        this.helper = new NonRecursivePropertyPlaceholderHelper("${", "}");
		this.template = template;
	}
	@Override
	public String getContentType() {
        return "text/html";
	}
	
	@Override
	public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		if (response.isCommitted()) {
            String message = getMessage(model);
            System.out.println(message);
			return;
		}
		if (response.getContentType() == null) {
			response.setContentType(getContentType());
		}

        PlaceholderResolver resolver = new ExpressionResolver(getExpressions(), model);
        String result = this.helper.replacePlaceholders(this.template, resolver);
        response.setCharacterEncoding("gb2312");
        response.getWriter().append(result);
        // response.getWriter().append(template);
	}

    private String getMessage(Map<String, ?> model) {
        Object path = model.get("path");
        String message = "Cannot render error page for request [" + path + "]";
        if (model.get("message") != null) {
            message += " and exception [" + model.get("message") + "]";
        }
        message += " as the response has already been committed.";
        message += " As a result, the response may have the wrong status code.";
        return message;
    }

    private Map<String, Expression> getExpressions() {
        if (this.expressions == null) {
            synchronized (this) {
                ExpressionCollector expressionCollector = new ExpressionCollector();
                this.helper.replacePlaceholders(this.template, expressionCollector);
                this.expressions = expressionCollector.getExpressions();
            }
        }
        return this.expressions;
    }

    /**
     * {@link PlaceholderResolver} to collect placeholder expressions.
     */
    private static class ExpressionCollector implements PlaceholderResolver {

        private final SpelExpressionParser parser = new SpelExpressionParser();

        private final Map<String, Expression> expressions = new HashMap<>();

        @Override
        public String resolvePlaceholder(String name) {
            this.expressions.put(name, this.parser.parseExpression(name));
            return null;
        }

        public Map<String, Expression> getExpressions() {
            return Collections.unmodifiableMap(this.expressions);
        }

    }

    /**
     * SpEL based {@link PlaceholderResolver}.
     */
    private static class ExpressionResolver implements PlaceholderResolver {

        private final Map<String, Expression> expressions;

        private final EvaluationContext context;

        ExpressionResolver(Map<String, Expression> expressions, Map<String, ?> map) {
            this.expressions = expressions;
            this.context = getContext(map);
        }

        private EvaluationContext getContext(Map<String, ?> map) {
            return SimpleEvaluationContext.forPropertyAccessors(new MapAccessor()).withRootObject(map).build();
        }

        @Override
        public String resolvePlaceholder(String placeholderName) {
            Expression expression = this.expressions.get(placeholderName);
            return escape(expression != null ? expression.getValue(this.context) : null);
        }

        private String escape(Object value) {
            return HtmlUtils.htmlEscape(value != null ? value.toString() : null);
        }

    }

    /**
     * {@link WebServerFactoryCustomizer} that configures the server's error pages.
     */
    // private static class ErrorPageCustomizer implements ErrorPageRegistrar,
    // Ordered {
    //
    // private final ServerProperties properties;
    //
    // protected ErrorPageCustomizer(ServerProperties properties) {
    // this.properties = properties;
    // }
    //
    // @Override
    // public void registerErrorPages(ErrorPageRegistry errorPageRegistry) {
    // ErrorPage errorPage = new ErrorPage(
    // this.properties.getServlet().getServletPrefix() +
    // this.properties.getError().getPath());
    // errorPageRegistry.addErrorPages(errorPage);
    // }
    //
    // @Override
    // public int getOrder() {
    // return 0;
    // }
    //
    // }
}
