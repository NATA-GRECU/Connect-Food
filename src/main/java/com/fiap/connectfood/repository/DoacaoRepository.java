package com.fiap.connectfood.repository;

import java.util.Date;
import java.util.List;


import com.fiap.connectfood.model.DoacaoModel;
import com.fiap.connectfood.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoacaoRepository extends JpaRepository<DoacaoModel, Integer> {

    List<DoacaoModel> findDonationByRestaurante(String restaurante);

    List<DoacaoModel> findDonationByInstituicao(String intituicao);

    List<DoacaoModel> findDonationByDataAgendamento(Date publicationDate);

    List<DoacaoModel> findDoacaoByDataAgendamentoBetween(Date publicationTimeStart, Date publicationTimeEnd);

    List<DoacaoModel> findByDoacaoFinalizada(boolean doacaoFinalizada);

    List<DoacaoModel> findDonationByInstituicaoAndDoacaoFinalizadaTrue(UserModel user);
    List<DoacaoModel> findDonationByRestauranteAndDoacaoFinalizadaTrue(UserModel user);

    List<DoacaoModel> findByRestaurante_Cnpj(String cnpj);
    List<DoacaoModel> findByInstituicao_Cnpj(String cnpj);
}