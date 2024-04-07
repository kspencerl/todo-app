package com.labdesoft.roteiro01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.labdesoft.roteiro01.entity.Label;
import com.labdesoft.roteiro01.service.LabelService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/labels")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/all")
    @Operation(summary = "Retorna todas as labels existentes")
    public ResponseEntity<List<Label>> findAllLabels() {
        List<Label> labels = labelService.getAllLabels();
        return ResponseEntity.ok().body(labels);
    }

    @GetMapping("/{name}")
    @Operation(summary = "Busca uma label específica")
    public ResponseEntity<Label> findLabelByName(@PathVariable String name) {
        Label label = labelService.getLabelByName(name);
        if (label != null) {
            return ResponseEntity.ok().body(label);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Adiciona uma nova label")
    public ResponseEntity<Label> addLabel(@RequestBody Label label) {
        Label addedLabel = labelService.addLabel(label);
        return ResponseEntity.ok().body(addedLabel);
    }

    @DeleteMapping("/delete/{name}")
    @Operation(summary = "Deleta uma label específica")
    public ResponseEntity<Void> deleteLabel(@PathVariable String name) {
        labelService.deleteLabel(name);
        return ResponseEntity.noContent().build();
    }
}
