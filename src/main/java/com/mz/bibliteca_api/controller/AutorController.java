@RestController
@RequestMapping("/autores")
class AutorController {

    private final AutorAIService aiService;

    public AutorController(AutorAIService aiService) {
        this.aiService = aiService;
    }

    @GetMapping
    public List<Autor> listar() { return aiService.listarAutores(); }

    @GetMapping("/{id}")
    public Autor obtener(@PathVariable Long id) { return aiService.obtenerAutor(id); }

    @PostMapping
    public Autor crear(@RequestBody Autor autor) { return aiService.crearAutor(autor); }
}