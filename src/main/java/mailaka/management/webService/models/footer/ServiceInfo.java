package mailaka.management.webService.models.footer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import mailaka.management.webService.models.AbstractEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@EqualsAndHashCode(callSuper = true)
public class ServiceInfo extends AbstractEntity {
    @Column(name = "premierService",nullable = true)
    private String premierMenu;
    @Column(name = "deuxiemeService",nullable = true)
    private String deuxiemeMenu;
    @Column(name = "troisiemeService",nullable = true)
    private String troisiemeMenu;
    @Column(name = "quatriemeService",nullable = true)
    private String quatriemeMenu;
    @Column(name = "cinquiemeService",nullable = true)
    private String cinquimeMenu;
    @Column(name = "sixiemeService",nullable = true)
    private String sixiemeMenu;
}
