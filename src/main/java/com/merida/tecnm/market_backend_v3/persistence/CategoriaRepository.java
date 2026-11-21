package com.merida.tecnm.market_backend_v3.persistence;

import com.merida.tecnm.market_backend_v3.domain.Category;
import com.merida.tecnm.market_backend_v3.domain.repository.CategoryRepository;
import com.merida.tecnm.market_backend_v3.persistence.crud.CategoriaCrudRepository;
import com.merida.tecnm.market_backend_v3.persistence.entity.Categoria;
import com.merida.tecnm.market_backend_v3.persistence.entity.mapper.CategoryMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    private final CategoriaCrudRepository categoriaCrudRepository;
    private final CategoryMapper mapper;

    public CategoriaRepository(CategoriaCrudRepository categoriaCrudRepository, CategoryMapper mapper) {
        this.categoriaCrudRepository = categoriaCrudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Category> getAll() {
        return mapper.toCategories((List<Categoria>) categoriaCrudRepository.findAll());
    }

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoriaCrudRepository.findById(categoryId).map(mapper::toCategory);
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        if (categoria.getIdCategoria() != null && categoria.getIdCategoria() == 0) {
            categoria.setIdCategoria(null);
        }
        return mapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public void delete(int categoryId) {
        categoriaCrudRepository.deleteById(categoryId);
    }
}
