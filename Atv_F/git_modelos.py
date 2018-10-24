class Repositorio:
    def __init__(self, nome):
        self.nome = nome
        self.arquivos = []
        self.commits = []

    def status(self):
        print("Arquivos Untracked: \n")
        for arquivo in self.arquivos:
            if not arquivo.get_tracked():
                print(arquivo.get_nome, "\n")
        print("\nMudanças para Commitar: \n")
        for arquivo in self.arquivos:
            if  arquivo.get_tracked():
                print(arquivo.get_nome, "\n")

class Arquivo:
    def __init__(self, nome, conteudo):
        self.nome = nome
        self.conteudo = conteudo
        self.mudanca = []
        self.tracked = False
        self.staged = False

    def get_tracked(self):
        return self.tracked

    def get_nome(self):
        return self.nome

    def get_staged(self):
        return self.staged

class Mudanca:
    def __init__(self, arquivo, tipo):
        self.arquivo = arquivo
        self.tipo = tipo
        self.staged = False

class Commit:
    pass