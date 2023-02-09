package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.*;
import org.testng.annotations.Test;

@Builder
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
    @Expose
    private String name;
    @EqualsAndHashCode.Exclude
    private int id;
    @Expose
    private String email;
    private String password;
    @Expose
    @SerializedName("is_active")
    @JsonProperty("is_active")
    private boolean isActive;
    @Expose
    @SerializedName("is_admin")
    private boolean isAdmin;
    @Expose
    @SerializedName("role_id")
    private int roleId;
    @Expose
    private String role;
    @EqualsAndHashCode.Exclude
    @SerializedName("email_notifications")
    private String emailNotifications;
}
