package br.com.fiap.nutrivibe.nutrivibe.model;

public enum UsuarioRole {
    ADMIN("admin"),
    PROFISSIONAL("profissional"),
    USER("user");

    private String role;

    UsuarioRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
