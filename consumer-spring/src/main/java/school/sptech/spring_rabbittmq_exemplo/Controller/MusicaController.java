package school.sptech.spring_rabbittmq_exemplo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.spring_rabbittmq_exemplo.Entitite.Musica;
import school.sptech.spring_rabbittmq_exemplo.service.MusicaService;

@RequestMapping("/musicas")
@RestController
public class MusicaController {

    @Autowired
    private MusicaService musicaService;

    @PostMapping("/enviar")
    public String enviarMusica(@RequestBody Musica musica) {
        return musicaService.enviarMusica(musica);
    }
}
