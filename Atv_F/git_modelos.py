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
        print("\nArquivos Tracked: \n")
        for arquivo in self.arquivos:
            if  arquivo.get_tracked():
                print(arquivo.get_nome, "\n")

class Arquivo:
    def __init__(self, nome, conteudo):
        self.nome = nome
        self.conteudo = conteudo
        self.mudanca = []
        self.tracked = False

    def get_tracked(self):
        return self.tracked

    def get_nome(self):
        return self.nome

class Mudanca:
    pass

class Commit:
    pass