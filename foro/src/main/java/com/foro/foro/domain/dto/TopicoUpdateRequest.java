package com.foro.foro.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TopicoUpdateRequest {

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 150, message = "El título no debe exceder 150 caracteres")
    private String titulo;

    @NotBlank(message = "El mensaje es obligatorio")
    private String mensaje;

    @NotBlank(message = "El status es obligatorio")
    private String status; // ABIERTO o CERRADO por ahora

    public TopicoUpdateRequest() {
    }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}