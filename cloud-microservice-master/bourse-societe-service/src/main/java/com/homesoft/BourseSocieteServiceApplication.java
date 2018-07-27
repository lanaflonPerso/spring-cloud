package com.homesoft;

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.http.MediaType;

import com.homesoft.dao.SocieteRepository;
import com.homesoft.entities.Societe;

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class BourseSocieteServiceApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(BourseSocieteServiceApplication.class, args);
		SocieteRepository societeRepository = ctx.getBean(SocieteRepository.class);
		Stream.of("Société tunisienne des industries de raffinage (STIR)",
				"Société tunisienne de l'électricité et du gaz (STEG)",
				"Groupe chimique tunisienSociété nationale de distribution des pétroles",
				"Tunisair",
				"Régie nationale des tabacs et des allumettes (RNTA)",
				"Entreprise tunisienne d'activités pétrolières (ETAP)",
				"Pharmacie centrale de Tunisie",
				"Ooredoo (Tunisie)|Orascom Telecom Tunisie",
				"Shell (compagnie)|Shell Tunisie",
				"Total SA|Total Tunisie",
				"Société de fabrication des boissons de Tunisie (SFBT)",
				"Nouvelair Tunisie",
				"Office national de l'huile (ONH)",
				"Compagnie des phosphates de Gafsa (CPG)",
				"Compagnie tunisienne de navigation (COTUNAV)",
				"Monoprix (Tunisie)|Monoprix",
				"Office du commerce de Tunisie (OCT)",
				"Office de l'aviation civile et des aéroports (OACA)",
				"Société nationale d'exploitation et de distribution des eaux (SONEDE)",
				"Société des emballages aluminium et des boissons gazeuses (SEABG)",
				"Carthage Power Compan",
				"Léoni Tunisie SA",
				"Société nationale des chemins de fer tunisiens")
				.forEach(s-> societeRepository.save(new Societe(s)));
		societeRepository.findAll().forEach(s->System.out.println(s.getNomSociete()));
	}
	
	@Configuration
	class myConfig extends RepositoryRestMvcConfiguration{
		@Override
		public RepositoryRestConfiguration config() {
			RepositoryRestConfiguration config = super.config();
			config.setBasePath("/");                
			config.findRepositoryMappingForPath("/");
	        config.setReturnBodyOnCreate(Boolean.TRUE);
	        config.setReturnBodyOnUpdate(Boolean.TRUE);        
	        config.setDefaultMediaType(MediaType.APPLICATION_JSON);     
			config.exposeIdsFor(Societe.class);
			return config;
		}
		
		
	}
}
