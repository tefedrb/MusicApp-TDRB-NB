package MusicApp.service;

import MusicApp.models.UserRole;

public interface UserRoleService {
    public UserRole createRole(UserRole newRole);
    public UserRole getRole(String roleName);
}
