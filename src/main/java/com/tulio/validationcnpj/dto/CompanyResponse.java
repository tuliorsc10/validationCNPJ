package com.tulio.validationcnpj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

public record CompanyResponse(

        String uf,

        @JsonProperty("cep")
        String postalCode,

        List<Object> qsa,

        String cnpj,
        String pais,
        String email,
        String porte,
        String bairro,
        String numero,

        @JsonProperty("ddd_fax")
        String dddFax,

        String municipio,
        String logradouro,

        @JsonProperty("cnae_fiscal")
        Long cnaeFiscal,

        @JsonProperty("codigo_pais")
        Integer codigoPais,

        String complemento,

        @JsonProperty("codigo_porte")
        Integer codigoPorte,

        @JsonProperty("razao_social")
        String razaoSocial,

        @JsonProperty("nome_fantasia")
        String nomeFantasia,

        @JsonProperty("capital_social")
        Double capitalSocial,

        @JsonProperty("ddd_telefone_1")
        String dddTelefone1,

        @JsonProperty("ddd_telefone_2")
        String dddTelefone2,

        @JsonProperty("opcao_pelo_mei")
        Boolean opcaoPeloMei,

        @JsonProperty("codigo_municipio")
        Integer codigoMunicipio,

        @JsonProperty("cnaes_secundarios")
        List<CnaeSecundario> cnaesSecundarios,

        @JsonProperty("natureza_juridica")
        String naturezaJuridica,

        @JsonProperty("regime_tributario")
        List<Object> regimeTributario,

        @JsonProperty("situacao_especial")
        String situacaoEspecial,

        @JsonProperty("opcao_pelo_simples")
        Boolean opcaoPeloSimples,

        @JsonProperty("situacao_cadastral")
        Integer situacaoCadastral,

        @JsonProperty("data_opcao_pelo_mei")
        String dataOpcaoPeloMei,

        @JsonProperty("data_exclusao_do_mei")
        String dataExclusaoDoMei,

        @JsonProperty("cnae_fiscal_descricao")
        String cnaeFiscalDescricao,

        @JsonProperty("codigo_municipio_ibge")
        Integer codigoMunicipioIbge,

        @JsonProperty("data_inicio_atividade")
        String dataInicioAtividade,

        @JsonProperty("data_situacao_especial")
        String dataSituacaoEspecial,

        @JsonProperty("data_opcao_pelo_simples")
        String dataOpcaoPeloSimples,

        @JsonProperty("data_situacao_cadastral")
        String dataSituacaoCadastral,

        @JsonProperty("nome_cidade_no_exterior")
        String nomeCidadeNoExterior,

        @JsonProperty("codigo_natureza_juridica")
        Integer codigoNaturezaJuridica,

        @JsonProperty("data_exclusao_do_simples")
        String dataExclusaoDoSimples,

        @JsonProperty("motivo_situacao_cadastral")
        Integer motivoSituacaoCadastral,

        @JsonProperty("ente_federativo_responsavel")
        String enteFederativoResponsavel,

        @JsonProperty("identificador_matriz_filial")
        Integer identificadorMatrizFilial,

        @JsonProperty("qualificacao_do_responsavel")
        Integer qualificacaoDoResponsavel,

        @JsonProperty("descricao_situacao_cadastral")
        String descricaoSituacaoCadastral,

        @JsonProperty("descricao_tipo_de_logradouro")
        String descricaoTipoDeLogradouro,

        @JsonProperty("descricao_motivo_situacao_cadastral")
        String descricaoMotivoSituacaoCadastral,

        @JsonProperty("descricao_identificador_matriz_filial")
        String descricaoIdentificadorMatrizFilial

) implements Serializable {
}