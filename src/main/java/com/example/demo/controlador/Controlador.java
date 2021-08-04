package com.example.demo.controlador;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.interfazservicios.IEquiposServicio;
import com.example.demo.interfazservicios.IPartidoServicio;
import com.example.demo.interfazservicios.IUsuarioServicio;
import com.example.demo.login.LoginService;
import com.example.demo.modelo.Equipos;
import com.example.demo.modelo.Partidos;
import com.example.demo.modelo.Usuarios;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private LoginService userService;

	@Autowired
	private IUsuarioServicio servicioUsuario;

	@Autowired
	private IPartidoServicio servicioPartido;

	@Autowired
	private IEquiposServicio servicioEquipo;

	private static Usuarios oauthUser;

	private static Usuarios usuarioEdit;
	private static Equipos localEdit;
	private static Equipos visitanteEdit;
	private static Date fechaEdit;
	private static int IdPartido = 0;

	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("user", new Usuarios());
		return mav;
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("user") Usuarios user) {
		oauthUser = userService.login(user.getUsername(), user.getPassword());

		System.out.print(oauthUser);
		if (Objects.nonNull(oauthUser)) {

			return "redirect:/listar";

		} else {
			return "redirect:/";

		}

	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/login";
	}

	@GetMapping(value = "/listar")
	public String listar(Model model) {
		if (Objects.nonNull(oauthUser)) {
			List<Partidos> partidos = servicioPartido.listarPartidos();
			model.addAttribute("partidos", partidos);
			return "principal";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("usuario", new Usuarios());
		return "registro";
	}

	@PostMapping("/save")
	public String save(@Validated Usuarios u, Model model) {
		servicioUsuario.save(u);
		System.out.println("USUARIOS--->" + u);
		return "redirect:/";
	}

	@GetMapping("/editarPartido/{id}")
	public String Editar(@PathVariable int id, Model model) {
		if (Objects.nonNull(oauthUser)) {
			Optional<Partidos> partido = servicioPartido.listarId(id);
			model.addAttribute("partidos", partido.get());
			IdPartido = partido.get().getId();
			usuarioEdit = partido.get().getUsuario();
			localEdit = partido.get().getLocal();
			visitanteEdit = partido.get().getVisitante();
			fechaEdit = partido.get().getFecha();
			System.out.println("PARTIDO editar--->" + partido.get());
			return "show";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/newPartido")
	public String agregarPartido(Model model) {
		if (Objects.nonNull(oauthUser)) {
			List<Equipos> equipos = servicioEquipo.listar();
			model.addAttribute("partidos", new Partidos());
			model.addAttribute("equipos", equipos);
			model.addAttribute("usuarios", new Usuarios());
			return "addPartido";
		} else {
			return "redirect:/";
		}

	}

	@PostMapping("/savePartido")
	public String savePartido(@Validated Partidos p, Model model) {
		if (Objects.nonNull(oauthUser)) {
			p.setUsuario(oauthUser);
			System.out.println("partido guardado---->" + p);
			servicioPartido.save(p);
			return "redirect:/listar";
		} else {
			return "redirect:/";
		}
	}

	@PostMapping("/savePartidoEditado")
	public String savePartidoEditado(@Validated Partidos p, Model model) {
		if (Objects.nonNull(oauthUser)) {
			p.setId(IdPartido);
			p.setUsuario(usuarioEdit);
			p.setLocal(localEdit);
			p.setVisitante(visitanteEdit);
			p.setFecha(fechaEdit);
			System.out.println("partido editado---->" + p);
			servicioPartido.save(p);
			return "redirect:/listar";
		} else {
			return "redirect:/";
		}
	}
}
