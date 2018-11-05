from servicos import *
import random

class conta:
    def __init__(self, numero_ag, titular, senha):
        self.numero_cc = random.randint(100, 900)
        self.numero_ag = numero_ag
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

    def get_nome(self):
        return self.titular.get_nome_titular()

class titular:
    def __init__(self, nome, cpf):
        self.nome = nome
        self.cpf = cpf

    def __str__(self):
        return "Nome do tilular: ", self.nome, "\nCPF: ", self.cpf

    def get_nome_titular(self):
        return self.nome
