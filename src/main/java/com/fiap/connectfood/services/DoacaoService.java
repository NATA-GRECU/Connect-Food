package com.fiap.connectfood.services;

import com.fiap.connectfood.model.DoacaoModel;
import com.fiap.connectfood.model.UserModel;
import com.fiap.connectfood.repository.DoacaoRepository;
import com.fiap.connectfood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DoacaoService {

    @Autowired
    DoacaoRepository doacaoRepository;

    @Autowired
    UserService userService;

    public void registerDonation(DoacaoModel doacaoModel)
    {
        doacaoRepository.save(doacaoModel);
    }

    public void deleteDonation(int id)
    {
        doacaoRepository.deleteById(id);
    }

    public DoacaoModel editDonation(int id, DoacaoModel doacaoModel)
    {
        doacaoModel.setId(id);
        doacaoRepository.save(doacaoModel);

        return doacaoModel;
    }

    public List<DoacaoModel> getAllDonations()
    {
        return doacaoRepository.findAll();
    }

    public Optional<DoacaoModel> getDonationById(int id)
    {
        return doacaoRepository.findById(id);
    }

    public List<DoacaoModel> getDonationByRestaurante(String restaurante)
    {
        return doacaoRepository.findDonationByRestaurante(restaurante);
    }

    public List<DoacaoModel> getDonationByInstituicao(String instituicao)
    {
        return doacaoRepository.findDonationByInstituicao(instituicao);
    }

    public List<DoacaoModel> getDonationByDate(Date date)
    {
        return doacaoRepository.findDonationByDataAgendamento(date);
    }

    public List<DoacaoModel> getDonationByDateBetween(Date startDate, Date endDate)
    {
        return doacaoRepository.findDoacaoByDataAgendamentoBetween(startDate, endDate);
    }

    public List<DoacaoModel> findByDoacaoFinalizada(String cnpj) {
        UserModel user = userService.getUserByCnpj(cnpj);

        List<DoacaoModel> doacoes = new ArrayList<>();
        doacoes.addAll(doacaoRepository.findDonationByInstituicaoAndDoacaoFinalizadaTrue(user));
        doacoes.addAll(doacaoRepository.findDonationByRestauranteAndDoacaoFinalizadaTrue(user));

        return doacoes;
    }

    public void finalizarDoacao(Integer id) {
        DoacaoModel doacaoModel = doacaoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Doação inexistente"));
        doacaoModel.setDoacaoFinalizada(true);
        doacaoModel.setDataFinalizado(Calendar.getInstance().getTime());
        doacaoRepository.save(doacaoModel);
    }

    public List<DoacaoModel> findDoacaoByCnpj(String cnpj)
    {
        List<DoacaoModel> doacoes = new ArrayList<>();

        doacoes.addAll(doacaoRepository.findByInstituicao_Cnpj(cnpj));
        doacoes.addAll(doacaoRepository.findByRestaurante_Cnpj(cnpj));

        return doacoes;
    }

}
