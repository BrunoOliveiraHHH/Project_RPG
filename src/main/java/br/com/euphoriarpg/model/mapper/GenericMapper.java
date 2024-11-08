package br.com.euphoriarpg.model.mapper;

import java.util.List;

public interface GenericMapper<E, D> {

	E toEntity(D dado);

	D toDto(E dado);

	List<E> toListEntity(List<D> listaDados);

	List<D> toListDto(List<E> listaDados);

}
