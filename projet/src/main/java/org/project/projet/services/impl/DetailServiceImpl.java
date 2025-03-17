package org.project.projet.services.impl;

import lombok.RequiredArgsConstructor;
import org.project.projet.data.models.Detail;
import org.project.projet.data.repository.DetailRespository;
import org.project.projet.services.DetailService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailServiceImpl implements DetailService {
    private final DetailRespository detailRespository;
    @Override
    public Page<Detail> findByCommandeId(Long commandeId, Pageable pageable) {
        return detailRespository.findByCommandeId(commandeId, pageable);
    }

    @Override
    public List<Detail> findByCommandeId(Long commandeId) {
        return detailRespository.findAll();
//        return detailRespository.findByCommandeId(commandeId);
    }
}
