package med.voll.api_voll.controller;

import jakarta.validation.Valid;

import med.voll.api_voll.domain.consulta.AgendaConsultaService;
import med.voll.api_voll.domain.consulta.DatosAgendarConsulta;
import med.voll.api_voll.domain.consulta.DatosDetalleConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/consultas")
public class ConsultaController {

    @Autowired
    private AgendaConsultaService service;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos){

        service.agendar(datos);
        return ResponseEntity.ok(new DatosDetalleConsulta(null,null,null,null));
    }
}