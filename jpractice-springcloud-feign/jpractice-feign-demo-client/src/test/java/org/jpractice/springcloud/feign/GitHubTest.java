/**
 * 
 */
package org.jpractice.springcloud.feign;

import java.util.List;

import org.jpractice.feign.demo.entity.Contributor;
import org.junit.Test;

import feign.Feign;
import feign.gson.GsonDecoder;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2018-12-20 09:00:03
 * @Description: TODO
 * @version V1.0
 */
public class GitHubTest {

    @Test
    public void test() {
        GitHub github = Feign.builder().decoder(new GsonDecoder()).target(GitHub.class, "https://api.github.com");

        // Fetch and print a list of the contributors to this library.
        List<Contributor> contributors = github.contributors("OpenFeign", "feign");
        for (Contributor contributor : contributors) {
            System.out.println(contributor.login + " (" + contributor.contributions + ")");
        }
    }

}
