package com.antiy.response.vul;

public class SseVulResponse {

    /**
     * 提示消息
     */
    private String notice;
    /**
     * 漏洞信息
     */
    private Item   item;

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public SseVulResponse() {
    }

    public static class Item {
        /**
         * 漏洞id
         */
        private Integer vulId;
        /**
         * 任务id
         */
        private Integer taskId;
        /**
         * 任务类型
         */
        private Integer taskType;

        public Integer getVulId() {
            return vulId;
        }

        public Item() {
        }

        public void setVulId(Integer vulId) {
            this.vulId = vulId;
        }

        public Integer getTaskId() {
            return taskId;
        }

        public void setTaskId(Integer taskId) {
            this.taskId = taskId;
        }

        public Integer getTaskType() {
            return taskType;
        }

        public void setTaskType(Integer taskType) {
            this.taskType = taskType;
        }
    }
}
