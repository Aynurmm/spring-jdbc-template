package az.academy.turing.springdemo.domain.mapper;

public interface EntityMapper<E, D> {
    E toEnt(D d);

    D toDto(E e);

}
