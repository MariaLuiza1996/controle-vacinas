$(document).ready(function () {
    $("input[name='cpf']").blur(function () {
        var $nome_aluno = $("input[name='nome_aluno']");
        var $rg = $("input[name='rg']");
        var cpf = $(this).val();
        
        $.getJSON('proc_pesq_user.php', {cpf},
            function(retorno){
                $nome_aluno.val(retorno.nome_aluno);
                $rg.val(retorno.rg);
            }
        );        
    });
});