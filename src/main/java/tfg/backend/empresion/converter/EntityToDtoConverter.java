package tfg.backend.empresion.converter;

public interface EntityToDtoConverter<T, S> {

    S entityToDto(T entity);

    T dtoToEntity(S dto);
}
