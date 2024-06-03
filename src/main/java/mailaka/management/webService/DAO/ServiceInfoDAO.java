package mailaka.management.webService.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import mailaka.management.webService.models.footer.ServiceInfo;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ServiceInfoDAO {
    private Integer id;
    private String premierMenu;
    private String deuxiemeMenu;
    private String troisiemeMenu;
    private String quatriemeMenu;
    private String cinquimeMenu;
    private String sixiemeMenu;


    public static ServiceInfoDAO fromEntity(ServiceInfo serviceInfo){
        if(serviceInfo==null){
            return null ;
        }
        return ServiceInfoDAO.builder()
                .premierMenu(serviceInfo.getPremierMenu())
                .deuxiemeMenu(serviceInfo.getDeuxiemeMenu())
                .troisiemeMenu(serviceInfo.getTroisiemeMenu())
                .quatriemeMenu(serviceInfo.getQuatriemeMenu())
                .cinquimeMenu(serviceInfo.getCinquimeMenu())
                .sixiemeMenu(serviceInfo.getSixiemeMenu())
                .build();
    }

    public static ServiceInfo toEntity(ServiceInfoDAO serviceInfoDAO){
        if(serviceInfoDAO==null){
            return null;
        }
        ServiceInfo serviceInfo= new ServiceInfo();

        serviceInfo.setId(serviceInfoDAO.getId());
        serviceInfo.setPremierMenu(serviceInfoDAO.getPremierMenu());
        serviceInfo.setDeuxiemeMenu(serviceInfoDAO.getDeuxiemeMenu());
        serviceInfo.setTroisiemeMenu(serviceInfoDAO.getTroisiemeMenu());
        serviceInfo.setQuatriemeMenu(serviceInfoDAO.getQuatriemeMenu());
        serviceInfo.setCinquimeMenu(serviceInfoDAO.getCinquimeMenu());
        serviceInfo.setSixiemeMenu(serviceInfoDAO.getSixiemeMenu());
        return serviceInfo;
    }
}
