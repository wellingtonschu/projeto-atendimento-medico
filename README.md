# projeto-atendimento-medico

Proposta: Desenvolver uma aplicação utilizando os conceitos de Programação Orientada a Objetos e Programação Básica para um estabelecimento de atendimento médico. A aplicação deve realizar o controle da fila de atendimento dos pacientes, para isso deve realizar uma classificação dos pacientes através de 4 perguntas que serão feitas aos pacientes no pré-atendimento. Assim os pacientes com problemas mais graves serão alocados no início da fila e os com problemas menos graves no final da fila.

Atividades:
•	Inserir pacientes na fila;
•	Realizar a classificação do paciente;
•	Mostrar a fila;
•	Simular o atendimento, removendo o primeiro paciente da fila;
•	Manter um histórico com os pacientes atendidos e os que ainda serão atendidos;
•	Ao sair da aplicação deve salvar os dados para quando a aplicação for iniciada novamente reapresentar os pacientes que ainda estão na fila aguardando atendimento;
•	Vários médicos podem atender, porém a fila de pacientes é única;
•	Armazenar o histórico de qual paciente cada médico atendeu;
•	Não utilizar interface gráfica;
•	Realizar a persistência utilizando XML;
•	Analisar e melhorar a usabilidade do sistema;

  Perguntas para a Triagem:
  1 - Há alguma fratura (osso quebrado)?
  2 - Há alguma hemorragia (Manchas na pele, ou perda de sangue)?
  3 - Houve desmaio (Paciente ficou desacordado em algum momento)?
  4 - Há alguma queimadura?
  
  Classificação de acordo com o número de "Sim":
  Nenhum sim – Estado azul – baixa complexidade – fim da fila
  1 ou 2 sim – Estado verde – Prioridade não urgente – antes do fim
  3 sm – Estado amarelo – Urgência – Após o inicio
  4 sm – Estado vermelho – Emergencia – Inicio da fila

