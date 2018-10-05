import random

class agencia:
    def __init__(self):
        self.numero_ag = 2027
        self.contas = []

    def criar_conta(self, nome, cpf, senha):
        self.contas.append(conta(titular(nome, cpf), senha))

    def deposito(self, num_conta, valor):
        for conta in self.contas:
            if num_conta == conta.numero_cc:
                conta.saldo += valor
                return True
        return False

    def valida_conta(self, num_conta, senha):
        for conta in self.contas:
            if num_conta == conta.numero_cc:
                if senha == conta.senha:
                    return conta
        return False

class conta:
    def __init__(self, titular, senha):
        self.numero_cc = random.randint(100, 900)
        self.numero_ag = 2027
        self.titular = titular
        self.senha = senha
        self.saldo = 0

    def saque(self, valor):
        if valor <= self.saldo:
            self.saldo -= valor
            return True
        return False

    def deposito(self, valor):
        self.saldo += valor

class titular:
    def __init__(self, nome, cpf):
        self.nome = nome
        self.cpf = cpf

    def __str__(self):
        return "Nome do tilular: ", self.nome, "\nCPF: ", self.cpf
