/**
 * 
 */
package org.jpractice.docker;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.spotify.docker.client.DefaultDockerClient;
import com.spotify.docker.client.DockerClient;
import com.spotify.docker.client.exceptions.DockerException;
import com.spotify.docker.client.messages.ContainerInfo;
import com.spotify.docker.client.messages.swarm.ConfigBind;
import com.spotify.docker.client.messages.swarm.Node;
import com.spotify.docker.client.messages.swarm.NodeInfo;
import com.spotify.docker.client.messages.swarm.NodeSpec;
import com.spotify.docker.client.messages.swarm.Service;
import com.spotify.docker.client.messages.swarm.Task;
import com.spotify.docker.client.messages.swarm.TaskSpec;
import com.spotify.docker.client.messages.swarm.TaskStatus;

/**
 * @author: 作者： xuefei
 * @date: 创建时间：2019-03-26 09:27:54
 * @Description: TODO
 * @version V1.0
 */
public class DockerSwarmClient {

    private void listNodes() {
        DockerClient dockerClient = DefaultDockerClient.builder().uri("unix:///var/run/docker.sock").build();
        try {

            List<Task> tasks = dockerClient.listTasks();
            tasks.forEach(task -> {

                TaskStatus taskStatus = task.status();
                System.out.println(taskStatus.containerStatus().containerId());
                try {
                    ContainerInfo containerInfo = dockerClient
                            .inspectContainer(taskStatus.containerStatus().containerId());
                    com.spotify.docker.client.messages.ContainerInfo.Node node = containerInfo.node();
                    node.id();
                } catch (DockerException | InterruptedException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                try {
                    Task task1 = dockerClient.inspectTask(task.id());
                } catch (DockerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                TaskSpec spec = task.spec();
                System.out.println(spec.toString());
                ImmutableList<ConfigBind> immutableList = spec.containerSpec().configs();
                System.out.println(task.name());
                System.out.println(task.nodeId());
            });

            List<Service> services = dockerClient.listServices();

            services.forEach(service -> {
                service.spec();
            });
            List<Node> nodes = dockerClient.listNodes();
            nodes.forEach(node -> {
                try {
                    NodeInfo info = dockerClient.inspectNode(node.id());
                } catch (DockerException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                NodeSpec nodeSpec = node.spec();
                System.out.println(nodeSpec.toString());
            });
        } catch (DockerException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DockerSwarmClient client = new DockerSwarmClient();
        client.listNodes();
    }

}
