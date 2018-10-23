class Repositorio:
    def __init__(self, nome):
        self.nome = nome
        self.arquivos = []
        self.commits = []

class Arquivo:
    def __init__(self, nome, conteudo):
        self.mudanca = []

class Mudanca:
    pass

class Commit:
    pass