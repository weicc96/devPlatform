package org.dev.plantform.response;

import lombok.Data;

/**
 * Describe: 前端 tree 结果封装数据
 * Author: weichenchen
 */
@Data
public class ResultTree {

    /**
     * 状态信息
     */
    private Status status = new Status();

    /**
     * 返回数据
     */
    private Object data;

    /**
     * 所需内部类
     */
    @Data
    public class Status {

        private Integer code = 200;

        private String message = "默认";
    }

    public static ResultTree data(Object data) {
        ResultTree resultTree = new ResultTree();
        resultTree.setData(data);
        return resultTree;
    }
}
