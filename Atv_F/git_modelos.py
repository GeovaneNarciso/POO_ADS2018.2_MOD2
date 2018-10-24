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
            if  arquivo.is_tracked():
                print(arquivo.ultimas_mudancas[0].get_tipo,": ",  end="")
                print(arquivo.get_nome, "\n")

    def criar_arquivo(self, nome, conteudo):
        for arquivo in self.arquivos:
            if arquivo.get_nome == nome:
                return "\nJá existe um arquivo com este nome.\n"
        self.arquivos.append(Arquivo(nome, conteudo))
        return "\nArquivo criado.\n"

    def listar_arquivos(self):
        for arquivo in self.arquivos:
            print(arquivo.get_nome, "\n")
            print("")

class Arquivo:
    def __init__(self, nome, conteudo):
        self.nome = nome
        self.conteudo = conteudo
        self.mudancas = [Mudanca(self, "Novo arquivo")]
        self.tracked = False
        #self.staged = False

    def is_tracked(self):
        return self.tracked

    def get_nome(self):
        return self.nome

    def get_staged(self):
        return self.staged

    def ultimas_mudancas(self):
        for mudanca in self.mudancas:
            if mudanca.staged:
                mudanca_true = mudanca
            else:
                mudanca_false = mudanca
        return  [mudanca_true, mudanca_false]

class Mudanca:
    def __init__(self, arquivo, tipo):
        self.arquivo = arquivo
        self.tipo = tipo
        self.staged = False
        self.commit = False

    def get_tipo(self):
        return self.tipo

class Commit:
    pass