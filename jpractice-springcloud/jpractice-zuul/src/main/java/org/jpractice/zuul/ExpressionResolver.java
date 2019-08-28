/**
 * 
 */
package org.jpractice.zuul;

import java.util.Map;

import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.util.PropertyPlaceholderHelper.PlaceholderResolver;
import org.springframework.web.util.HtmlUtils;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-01-21 16:05:13
 * @Description: TODO
 * @version V1.0
 */
public class ExpressionResolver implements PlaceholderResolver {

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
