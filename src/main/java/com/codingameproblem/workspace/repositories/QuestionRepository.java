package com.codingameproblem.workspace.repositories;

import com.codingameproblem.workspace.entities.Level;
import com.codingameproblem.workspace.entities.Question;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class QuestionRepository implements IQuestionRepository {

    private final Map<String, Question> questionMap;
    private Integer autoIncrement = 0;

    public QuestionRepository(){
        questionMap = new HashMap<String,Question>();
    }

    public QuestionRepository(Map<String, Question> questionMap) {
        this.questionMap = questionMap;
        this.autoIncrement = questionMap.size();
    }

    @Override
    public Question save(Question entity) {
        if( entity.getId() == null ){
            autoIncrement++;
            Question q = new Question(Integer.toString(autoIncrement),entity.getTitle(),entity.getLevel(),entity.getScore());
            questionMap.put(q.getId(),q);
            return q;
        }
        questionMap.put(entity.getId(),entity);
        return entity;
    }

    // TODO: CRIO_TASK_MODULE_SERVICES
    // Find all the list of Question Present in the Repository
    // Tip:- Use Java Streams

    @Override
    public List<Question> findAll() {
        //return Collections.emptyList();
        return questionMap.values().stream().collect(Collectors.toList());
    }

    @Override
    public Optional<Question> findById(String id) {
        return Optional.ofNullable(questionMap.get(id));
    }

    @Override
    public boolean existsById(String id) {
        return questionMap.containsKey(id);
    }

    @Override
    public void delete(Question entity) {
        questionMap.remove(entity.getId());
    }

    @Override
    public void deleteById(String id) {
        questionMap.remove(id);
    }

    @Override
    public long count() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Question> findAllQuestionLevelWise(Level level) {
        return questionMap.values()
                .stream()
                .filter(e -> level.equals(e.getLevel()))
                .collect(Collectors.toList());
    }
}

