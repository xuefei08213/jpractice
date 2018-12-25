/**
 * 
 */
package org.jpractice.springcloud.feign;

import java.util.List;

import org.jpractice.feign.demo.entity.Contributor;

import feign.Param;
import feign.RequestLine;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-20 08:53:34
 * @Description: TODO
 * @version V1.0
 */
public interface GitHub {

    @RequestLine("GET /repos/{owner}/{repo}/contributors")
    List<Contributor> contributors(@Param("owner") String owner, @Param("repo") String repo);

}
