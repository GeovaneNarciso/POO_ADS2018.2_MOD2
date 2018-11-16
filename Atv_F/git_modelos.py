class Repositorio:
    def __init__(self, nome):
        self.nome = nome
        self.arquivos = []
        self.commits = []

    def status(self):
        print("Arquivos Untracked: \n")
        for arquivo in self.arquivos:
            if not arquivo.is_tracked():
                print("   * ", arquivo.get_nome())
        print("\nMudanças para Commitar: \n")
        for arquivo in self.arquivos:
            if  arquivo.is_tracked():
                print(arquivo.ultimas_mudancas()[0].get_tipo(),": ",  end="")
                print(arquivo.get_nome(), "\n")

    def criar_arquivo(self, nome, conteudo):
        for arquivo in self.arquivos:
            if arquivo.get_nome() == nome:
                return "\n***** Já existe um arquivo com este nome. *****\n"
        self.arquivos.append(Arquivo(nome, conteudo))
        return "\n***** Arquivo criado. *****\n"

    def listar_arquivos(self):
        for arquivo in self.arquivos:
            print(arquivo.get_nome())
        print("")

    def busca_nome(self, nome):
        for arquivo in self.arquivos:
            if arquivo.get_nome() == nome:
                return True
        return False

    def add(self, nome, busca):
        if busca:
            for arquivo in self.arquivos:
                if arquivo.get_nome() == nome:
                    arquivo.add()
                    return " "
        else:
            return "\nNão há arquivo com este nome.\n"

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

    def add(self):
        for mudanca in self.mudancas:
            if not mudanca.commit:
                mudanca.stage()
        self.tracked = True

class Mudanca:
    def __init__(self, arquivo, tipo):
        self.arquivo = arquivo
        self.tipo = tipo
        self.staged = False
        self.commit = False

    def get_tipo(self):
        return self.tipo

    def stage(self):
        self.staged = True

    def unstage(self):
        self.staged = False

class Commit:
    pass