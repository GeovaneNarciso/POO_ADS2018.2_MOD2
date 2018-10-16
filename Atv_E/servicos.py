from modelos import *

class agencia:
    def __init__(self):
        self.numero_ag = 2027
        self.contas = []

    def criar_conta(self, nome, cpf, senha):
        self.contas.append(conta(self.numero_ag, titular(nome, cpf), senha))

    def deposito(self, num_conta, valor):
        for conta in self.contas:
            if num_conta == conta.numero_cc:
                conta.deposito(valor)
                return True
        return False

    def valida_conta(self, num_conta, senha):
        for conta in self.contas:
            if num_conta == conta.numero_cc:
                if senha == conta.senha:
                    return conta
        return False

    def __getattr__(self):
        return self.numero_ag

agencia_a = agencia()
