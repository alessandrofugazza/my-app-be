package com.naru.my_app_be.projects.controller;

import com.naru.my_app_be.projects.service.ProjectService;
import com.naru.my_app_be.projects.entity.Project;
import com.naru.my_app_be.purchases.entity.Purchase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projects/v1")
@RequiredArgsConstructor
@Validated
public class ProjectController {

    private final ProjectService projectService;

    @GetMapping("/")
    public ResponseEntity<List<Project>> getAllProjects(){
        return ResponseEntity.ok().body(projectService.getAllProjects());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable UUID id)
    {
        return ResponseEntity.ok().body(projectService.getProjectById(id));
    }
    
    @PostMapping("/")
    public ResponseEntity<Project> saveProject(@RequestBody Project project)
    {
        return ResponseEntity.ok().body(projectService.saveProject(project));
    }

    @PutMapping("/{id}/todos")
    public ResponseEntity<Project> addTodoToProject(@PathVariable UUID id, @RequestBody String todo) {
        Project updatedProject = projectService.addTodoToProject(id, todo);
        return ResponseEntity.ok().body(updatedProject);
    }

    @PatchMapping("/{id}/title")
    public ResponseEntity<Project> updateProjectTitle(@PathVariable UUID id, @RequestBody String newTitle)
    {
        return ResponseEntity.ok().body(projectService.updateProjectTitle(id, newTitle));
    }

    @PatchMapping("/{id}/description")
    public ResponseEntity<Project> updateProjectDescription(@PathVariable UUID id, @RequestBody String newDescription)
    {
        return ResponseEntity.ok().body(projectService.updateProjectDescription(id, newDescription));
    }

    @PatchMapping("/{id}/todos")
        public ResponseEntity<Project> updateProjectTodos(@PathVariable UUID id, @RequestBody String newDescription)
        {
            return ResponseEntity.ok().body(projectService.updateProjectDescription(id, newDescription));
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProjectById(@PathVariable UUID id)
    {
        projectService.deleteProjectById(id);
        return ResponseEntity.ok().body("Deleted project successfully");
    }


}
