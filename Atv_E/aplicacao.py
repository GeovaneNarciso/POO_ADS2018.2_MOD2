from modelos import *
import random

def main():
    agencia_a = agencia()
    while True:
        print("\n\n########## BANCO G ##########\n\n"
              "1 - | Entrar         |\n"
              "2 - | Criar conta    |\n"
              "3 - | Fazer depósito |\n")

        opcao_a = int(input("Informe sua opção: "))

        if opcao_a == 1:
            num_conta = int(input("Número da conta: "))
            senha = int(input("Informe sua senha:"))
            conta_logada = agencia_a.valida_conta(num_conta, senha)
            if conta_logada:
                opcao_b = -1
                while opcao_b != 0:
                    nome_titular = conta_logada.titular.nome
                    print("\n\n########## BANCO G ##########\n\n"
                          "Bem Vindo", nome_titular, "\n"
                          "1 - | Saque    |\n"
                          "2 - | Depósito |\n"
                          "3 - | Saldo    |\n"
                          "0 - | Sair     |\n")
                    opcao_b = int(input("Informe sua opção: "))
                    if opcao_b == 1:
                        valor = float(input("\nValor: "))
                        if conta_logada.saque(valor):
                            print("\nSaque realizado com sucesso.")
                        else:
                            print("\nSaldo insuficiente.")

                    elif opcao_b == 2:
                        valor = float(input("\nValor: "))
                        conta_logada.deposito(valor)
                        print("\nDepósito realizado com sucesso.")

                    elif opcao_b == 3:
                        print("\nSaldo Atual: R$ {:.2f}" .format(conta_logada.saldo))
            else:
                print("\nNúmero da conta ou senha inválido(s).")

        elif opcao_a == 2:
            nome = input("\nNome completo: ")
            cpf = int(input("CPF: "))
            senha = int(input("Informe uma senha:"))
            agencia_a.criar_conta(nome, cpf, senha)
            print("\nConta criada com sucesso.")

        elif opcao_a == 3:
            num_conta = int(input("Número da conta: "))
            valor = float(input("Valor: "))
            if agencia_a.deposito(num_conta, valor):
                print("\nDepósito realizado com sucesso.")
            else:
                print("\nNúmero de conta inválido.")

        print()
        for conta in agencia_a.contas:
            print("*** Informações p/ facilitar o teste do código ***")
            print("Conta    Titular    Saldo")
            print(conta.numero_cc, conta.titular.nome, conta.saldo)

if __name__ == '__main__':
    main()

