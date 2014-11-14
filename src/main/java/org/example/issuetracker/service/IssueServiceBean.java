package org.example.issuetracker.service;

import java.util.List;

import org.example.issuetracker.model.IssuePriority;
import org.example.issuetracker.model.IssueStatus;
import org.example.issuetracker.model.jpa.Issue;
import org.example.issuetracker.repository.jpa.IssueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssueServiceBean implements IssueService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IssueRepository issueRepository;

    @Override
    public List<Issue> findAll() {
        logger.info("> findAll");

        List<Issue> issues = issueRepository.findAll();

        logger.info("< findAll");
        return issues;
    }

    @Override
    public Issue create(Issue issue) {
        logger.info("> create");

        // Set default attribute values
        issue.setStatus(IssueStatus.OPEN);

        if (issue.getPriority() == null) {
            issue.setPriority(IssuePriority.MEDIUM);
        }

        Issue i = issueRepository.save(issue);

        logger.info("< create");
        return i;
    }

    @Override
    public Issue update(Issue issue) {
        logger.info("> update");

        Issue i = issueRepository.save(issue);

        logger.info("< update");
        return i;
    }

}
