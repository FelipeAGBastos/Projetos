tickets_estacionamento = [
    {"ticket_id": "TKT-1234", "placa": "ABC-1234", "horas_uso": 2.5, "status_pagamento": "Pago"},
    {"ticket_id": "TKT-5678", "placa": "DFG-5678",  "horas_uso": 0.5, "status_pagamento": "Pendente"},
    {"ticket_id": "TKT-8910", "placa": "HIJ-9101", "horas_uso": 8.0, "status_pagamento": "Pendente"}
]


def gerar_mensagem_estacionamento(ticket):
    placa = ticket['placa']
    horas = ticket['horas_uso']
    
    if ticket['status_pagamento'] == 'Pendente':
        return f"Atenção: O veículo placa {placa} possui um débito em aberto referente a {horas} horas de uso. Por favor, regularize no caixa."
    elif ticket['status_pagamento'] == 'Pago':
        return f"Agradecemos a preferência! O veículo placa {placa} está liberado. Volte sempre."
    else:
        return f"Status desconhecido para o veículo {placa}. Por favor, procure a gerência."

for ticket in tickets_estacionamento:
    mensagem_criada = gerar_mensagem_estacionamento(ticket)
    
    print(mensagem_criada)
    
    ticket['mensagem_gerada'] = mensagem_criada

    print("--- RELATÓRIO FINAL DO ESTACIONAMENTO ---")

for ticket in tickets_estacionamento:
    print(ticket['placa'], "->", ticket['mensagem_gerada'])

print("-----------------------------------------")
print("Processo de ETL concluído com sucesso!")