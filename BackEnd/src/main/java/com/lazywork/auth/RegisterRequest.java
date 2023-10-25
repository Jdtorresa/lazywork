package com.lazywork.auth;

import com.lazywork.User.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    String nombre;
    String apellido;
    String documento;
    String nivelSoporte;
    String contraseña;
    Role rol;

}
