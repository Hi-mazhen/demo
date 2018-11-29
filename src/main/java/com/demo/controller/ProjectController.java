package com.demo.controller;

import com.demo.entity.Project;
import com.demo.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
@PreAuthorize("hasRole('USER')")
public class ProjectController {

    private IProjectService service;

    @Autowired
    public ProjectController(IProjectService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Page<Project> findRelated(
            @RequestHeader(value = "userId") String userId,
            @RequestParam(value = "enabled", defaultValue = "true", required = false) boolean enabled,
            @RequestParam(value = "archived", defaultValue = "false", required = false) boolean archived,
            Pageable pageable) {
        return service.findRelated(userId, enabled, archived, pageable);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Project add(@RequestBody Project project, @RequestHeader(value = "userId") String userId){
        return service.add(project, userId);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Project findById(@PathVariable String id) {
        return service.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Project update(@PathVariable String id, @RequestBody Project project){
        project.setId(id);
        return service.update(project);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Project delete(@PathVariable String id){
        return service.delete(id);
    }
}
