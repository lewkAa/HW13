package ru.netology.domain;

public class Meeting extends Task {
    protected String topic;
    protected String time;
    protected String project;

    public String getTopic() {
        return topic;
    }

    public String getTime() {
        return time;
    }

    public String getProject() {
        return project;
    }

    public Meeting (int id, String topic, String time, String project){
        super(id);
        this.topic = topic;
        this.project = project;
        this.time = time;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

}
