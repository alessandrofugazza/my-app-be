package com.naru.my_app_be.projects.service;


import com.naru.my_app_be.exceptions.ResourceNotFoundException;
import com.naru.my_app_be.projects.entity.Project;
import com.naru.my_app_be.projects.repository.ProjectRepo;
import com.naru.my_app_be.purchases.entity.Purchase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {

    private final ProjectRepo projectRepo;

    public List<Project> getAllProjects(){
        return projectRepo.findAll();
    }

    public Project getProjectById(UUID id){
        Optional<Project> optionalProject = projectRepo.findById(id);
        if(optionalProject.isPresent()){
            return optionalProject.get();
        }
        log.info("Project with id: {} doesn't exist", id);
        return null;
    }

    public Project saveProject (Project project){
        project.setCreatedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());
        Project savedProject = projectRepo.save(project);

        log.info("Project with id: {} saved successfully", project.getId());
        return savedProject;
    }

    public Project updateProject (Project project) {
        Optional<Project> existingProject = projectRepo.findById(project.getId());
        project.setCreatedAt(existingProject.get().getCreatedAt());
        project.setUpdatedAt(LocalDateTime.now());

        Project updatedProject = projectRepo.save(project);

        log.info("Project with id: {} updated successfully", project.getId());
        return updatedProject;
    }

    public Project updateProjectTitle (UUID id, String newTitle) {
        Project project = projectRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
        project.setTitle(newTitle);
        project.setUpdatedAt(LocalDateTime.now());

        Project updatedProject = projectRepo.save(project);

        log.info("Title of project with id: {} updated successfully", updatedProject.getId());
        return updatedProject;
    }
    
public Project updateProjectDescription (UUID id, String newDescription) {
        Project project = projectRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + id));
        project.setDescription(newDescription);
        project.setUpdatedAt(LocalDateTime.now());

        Project updatedProject = projectRepo.save(project);

        log.info("Description of project with id: {} updated successfully", updatedProject.getId());
        return updatedProject;
    }

    public Project addTodoToProject(UUID projectId, String newTodo) {
        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + projectId));
        List<String> todos = project.getTodos();
        todos.add(newTodo); // Automatically appends to the end of the list
        project.setTodos(todos); // Reassign to ensure the list updates the order column
        Project updatedProject = projectRepo.save(project);

        log.info("Description of project with id: {} updated successfully", updatedProject.getId());
        return updatedProject;
    }


    public void deleteProjectById (UUID id) {
        projectRepo.deleteById(id);
    }

}
