function handleSendMessage() {
  const form = document.querySelector('#form');
  errorContainer.innerHTML = '';

  // Desestruturando do form
  const {
    name,
    cpf,
    email,
    phone,
    city,
    state,
    subject,
    message
  } = form;

  // Pegando os valores
  var nomeValue = name.value,
    cpfValue = cpf.value,
    emailValue = email.value,
    telefoneValue = phone.value,
    cidadeValue = city.value,
    estadoValue = state.value,
    assuntoValue = subject.value,
    mensagemValue = message.value

  const fields = [
    nomeValue, emailValue, assuntoValue, mensagemValue
  ];

  // Verificar campos vazios com exceção do complemento
  if (fields.every(field => field != '')) {
    console.log('Todos obrigatorios preenchidos');

    if (cpfValue != '') {
        if (isCPFValid(cpfValue)) {
            confirm(
                `
                Enviado com sucesso, ${nomeValue}!
                    Nome: ${nomeValue}
                    Cpf: ${cpfValue != '' ? cpfValue : 'Não informado'}
                    Email: ${emailValue}
                    Telefone: ${telefoneValue != '' ? telefoneValue : 'não informado'}
                    Assunto: ${assuntoValue}
                    Mensagem: ${mensagemValue}
                    Estado: ${estadoValue != '' ? estadoValue : 'não informado'}
                    Cidade: ${cidadeValue != '' ? cidadeValue : 'não informado'}
                `
            );
        } else {
            console.log('cpf inválido');
            errorContainer.innerHTML = 'CPF inválido';
        }
    } else {
        confirm(
            `
            Enviado com sucesso, ${nomeValue}!
                Nome: ${nomeValue}
                Cpf: ${cpfValue != '' ? cpfValue : 'Não informado'}
                Email: ${emailValue}
                Telefone: ${telefoneValue != '' ? telefoneValue : 'não informado'}
                Assunto: ${assuntoValue}
                Mensagem: ${mensagemValue}
                Estado: ${estadoValue != '' ? estadoValue : 'não informado'}
                Cidade: ${cidadeValue != '' ? cidadeValue : 'não informado'}
            `
        );
    }

  } else {
    var errors = [];

    if (nomeValue == '') {
        errors.push('nome');
        name.focus()
    }

    if (emailValue == '') {
        errors.push('email')
        email.focus();
    };

    if (assuntoValue == '') {
        errors.push('assunto')
        subject.focus();
    };

    if (mensagemValue == '') {
        errors.push('mensagem');
        message.focus();
    };


    const errosMsg = `
        Preencha todos os campos obrigatórios: ${errors.join(', ')}
    `;

    errorContainer.innerHTML = errosMsg;
  }
}

function isCPFValid(strCPF) {
    var Soma;
    var Resto;
    Soma = 0;
    if (strCPF == '00000000000') return false;
  
    for (i = 1; i <= 9; i++)
      Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (11 - i);
    Resto = (Soma * 10) % 11;
  
    if (Resto == 10 || Resto == 11) Resto = 0;
    if (Resto != parseInt(strCPF.substring(9, 10))) return false;
  
    Soma = 0;
    for (i = 1; i <= 10; i++)
      Soma = Soma + parseInt(strCPF.substring(i - 1, i)) * (12 - i);
    Resto = (Soma * 10) % 11;
  
    if (Resto == 10 || Resto == 11) Resto = 0;
    if (Resto != parseInt(strCPF.substring(10, 11))) return false;
    return true;
}
