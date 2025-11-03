@Service
class AutorService {

    private final AutorRepository repository;

    public AutorService(AutorRepository repository) {
        this.repository = repository;
    }

    public List<Autor> listar() { return repository.findAll(); }
    public Autor obtener(Long id) { return repository.findById(id).orElse(null); }
    public Autor guardar(Autor autor) { return repository.save(autor); }
    public void eliminar(Long id) { repository.deleteById(id); }
}