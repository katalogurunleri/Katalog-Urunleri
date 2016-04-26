var Nodo = function(d) {
    var dato;
    var LI;
    var LD;
    var anchoNodo = 100;
    var altoNodo = 40;
    this.directorio = new Directorio(100);
    this.direccion = this.directorio.pedirDireccion();
    var FB;

    this.asignarDato(d);
    this.asignarFB(0);
    this.asignarLI(null);
    this.asignarLD(null);

    //this.limpiarFondo();
};

Nodo.prototype.asignarDato = function(d) {
    this.dato = d;
};

Nodo.prototype.obtenerDato = function() {
    return this.dato;
};

Nodo.prototype.asignarLI = function(x) {
    this.LI = x;
};

Nodo.prototype.obtenerLI = function() {
    return this.LI;
};

Nodo.prototype.asignarLD = function(y) {
    this.LD = y;
};

Nodo.prototype.obtenerLD = function() {
    return this.LD;
};

Nodo.prototype.asignarFB = function(y) {
    this.FB = y;
};

Nodo.prototype.obtenerFB = function() {
    return this.FB;
};

Nodo.prototype.pintarNodo = function(can, x, y) {

    can.beginPath();
    can.strokeStyle = "#00a383";
    can.fillStyle = "#000";
    can.strokeRect(x, y, 200, 40);

    can.moveTo(x + 30, y);
    can.lineTo(x + 30, y + 40);

    can.moveTo(x + 170, y);
    can.lineTo(x + 170, y + 40);

    can.font = "20px Arial";
    can.fillText(this.obtenerDato(), x + 40, y + 30);

    if (this.obtenerLI() === null) {
        can.font = "15px Arial";
        can.fillText("null", x + 5, y + 25);
    } else {
        can.font = "15px Arial";
        can.fillText(this.obtenerLI().direccion, x + 5, y + 25);

    }

    if (this.obtenerLD() === null) {
        can.font = "15px Arial";
        can.fillText("null", x + 175, y + 25);
    } else {
        can.font = "15px Arial";
        can.fillText(this.obtenerLD().direccion, x + 175, y + 25);

    }

    can.font = "10px Arial";
    can.fillText(this.direccion, x, y - 3);

    can.font = "10px Arial";
    can.fillText("FB:" + this.FB, x + 180, y - 3);

    can.stroke();
    can.closePath();
};

Nodo.prototype.pintarFondo = function(can, x, y) {
    can.beginPath();
    can.fillStyle = "#63FFDE";
    can.fillRect(x, y, 100, 40);
    can.stroke();
    can.closePath();

};

//Directorio = direccion del nodo 
var Directorio = function(x) {
    this.N = x;
    this.vdir = [100];
    this.ndir = 0;

};

Directorio.prototype.pedirDireccion = function() {
    var n;
    while (this.dirUtilizada(this.n = Math.floor(Math.random() * 100))) {
    }
    this.vdir.push(this.n);
    return this.n;
};

Directorio.prototype.dirUtilizada = function(x) {
    var respuesta;
    for (var i = 0; !(i >= this.ndir || respuesta); ++i) {
        if (this.vdir[i] !== x) {
            respuesta = true;
        }
        ;
    }
    ;

};


//Arbol Binario

var ArbolBinario = function() {
    this.raiz = null;
};


ArbolBinario.prototype.obtenerRaiz = function() {
    return this.raiz;
};

ArbolBinario.prototype.asignarRaiz = function(p) {
    this.raiz = p;
};
ArbolBinario.prototype.insertar = function(dato) {
    this.insertarRecursivo(this.obtenerRaiz(), null, dato);
    this.calcFB(this.obtenerRaiz());
    this.rotar(this.obtenerRaiz(), null);
    this.calcFB(this.obtenerRaiz());

};

ArbolBinario.prototype.insertarRecursivo = function(p, ant, dato) {
    if (p !== null) {
        if (dato < p.obtenerDato()) {
            this.insertarRecursivo(p.obtenerLI(), p, dato);
        }
        ;
        if (dato > p.obtenerDato()) {
            this.insertarRecursivo(p.obtenerLD(), p, dato);
        }
        ;
    } else if (ant !== null) {

        if (dato < ant.obtenerDato()) {
            var q;
            q = new Nodo(dato);
            ant.asignarLI(q);
        } else if (dato > ant.obtenerDato()) {
            var q;
            q = new Nodo(dato);
            ant.asignarLD(q);
        }
        ;
    } else if (ant === null) {
        var q;
        this.raiz = q = new Nodo(dato);
    }
    ;
};

ArbolBinario.prototype.existe = function(dato) {
    return this.existeR(this.obtenerRaiz(), dato);
};

ArbolBinario.prototype.existeR = function(p, dato) {
    c = false;
    if (p !== null) {
        if (p.obtenerDato() === dato) {
            c = true;
        }
        ;
        c = c || this.existeR(p.obtenerLI(), dato);
        c = c || this.existeR(p.obtenerLD(), dato);

    }
    ;
    return c;
};

ArbolBinario.prototype.contarHojasR = function(p) {
    var c = 0;
    if (p !== null) {
        if (p.obtenerLI() === null && p.obtenerLD() === null) {
            c++;

        }
        ;
        c = c + this.contarHojasR(p.obtenerLI());
        c = c + this.contarHojasR(p.obtenerLD());
    }
    ;
    return c;
};

ArbolBinario.prototype.contarHojas = function() {
    var c = this.contarHojasR(this.obtenerRaiz());

    return c;
};

ArbolBinario.prototype.recorridoIN = function(p) {
    var res = "";
    if (p !== null) {

        res = res + this.recorridoIN(p.obtenerLI());
        res = res + p.obtenerDato();
        res = res + this.recorridoIN(p.obtenerLD());
    }
    ;
    return res + " ";
};

ArbolBinario.prototype.recorridoPOS = function(p) {
    var res = "";
    if (p !== null) {

        res = res + this.recorridoPOS(p.obtenerLI());
        res = res + this.recorridoPOS(p.obtenerLD());
        res = res + p.obtenerDato();

    }
    ;
    return res + " ";
};

ArbolBinario.prototype.recorridoPRE = function(p) {
    var res = "";
    if (p !== null) {

        res = res + p.obtenerDato();
        res = res + this.recorridoPRE(p.obtenerLI());
        res = res + this.recorridoPRE(p.obtenerLD());
    }
    ;
    return res;
};

ArbolBinario.prototype.alturaArbolR = function(p) {
    var c = 0;
    if (p !== null) {
        c = (1 + Math.max(this.alturaArbolR(p.obtenerLI()), this.alturaArbolR(p.obtenerLD())));
    }
    ;
    return c;
};

ArbolBinario.prototype.pintarR = function(can, p, x, y) {
    var radio = 70;
    if (p !== null) {
        var delta;
        if (p.obtenerLI() !== null) {
            can.strokeStyle = "#00a383";
            delta = (this.contarNodosIzquierdos(p) + 1) * radio;
            can.beginPath();
            can.moveTo(x, y + 20);
            can.lineTo(x - delta + 50, y + 20);
            can.lineTo(x - delta + 50, y + radio);
            can.stroke();
            can.closePath();
            this.pintarR(can, p.obtenerLI(), x - delta, y + radio);
        }
        ;
        if (p.obtenerLD() !== null) {
            can.strokeStyle = "#00a383";
            delta = (this.contarNodosDerechos(p) + 1) * radio;
            can.beginPath();
            can.moveTo(x + 200, y + 20);
            can.lineTo(x + 130 + delta, y + 20);
            can.lineTo(x + 130 + delta, y + radio);
            can.stroke();
            can.closePath();
            this.pintarR(can, p.obtenerLD(), x + delta, y + radio);
        }
        ;
        p.pintarNodo(can, x, y);
    }
    ;
};

ArbolBinario.prototype.pintar = function(can, x, y) {
    this.pintarR(can, this.obtenerRaiz(), x, y);
};

ArbolBinario.prototype.pintarFondoNodo = function(can, p, x, y, dato) {
    var radio = 48;

    if (p !== null) {
        var delta;
        if (p.obtenerLI !== null) {
            delta = (this.contarNodosIzquierdos(p) + 1) * radio;
            this.pintarFondoNodo(can, p.obtenerLI(), x - delta, y + radio, dato);
        }
        ;
        if (p.obtenerLD !== null) {
            delta = (this.contarNodosDerechos(p) + 1) * radio;
            this.pintarFondoNodo(can, p.obtenerLD(), x + delta, y + radio, dato);
        }
        ;
        if (p.obtenerDato() === dato) {
            p.pintarFondo(can, x, y);
        }
    }
    ;
};

ArbolBinario.prototype.calcFB = function(p) {
    var c = 0;
    if (p !== null) {
        c = this.alturaArbolR(p.obtenerLI()) - this.alturaArbolR(p.obtenerLD());
        p.asignarFB(c);
        if (p.obtenerLI() !== null) {
            this.calcFB(p.obtenerLI());
        }
        ;
        if (p.obtenerLD() !== null) {
            this.calcFB(p.obtenerLD());
        }
        ;
    }
    ;
};

ArbolBinario.prototype.rotar = function(p, ant) {
    if (p != null) {
        if (p.obtenerFB() == 2 && p.obtenerLI().obtenerFB() == 1 && this.evaluarHijos(p) == false) {
            if (ant == null) {
                this.asignarRaiz(this.rotDer(p, p.obtenerLI()));
            } else if (ant.obtenerLI() == p) {
                ant.asignarLI(this.rotDer(p, p.obtenerLI()));
            } else {
                ant.asignarLD(this.rotDer(p, p.obtenerLI()));
            }
            ;
            this.calcFB(this.obtenerRaiz());
        } else if (p.obtenerFB() == -2 && p.obtenerLD().obtenerFB() == -1 && this.evaluarHijos(p) == false) {
            if (ant == null) {
                this.asignarRaiz(this.rotIzq(p, p.obtenerLD()));
            } else if (ant.obtenerLI() == p) {
                ant.asignarLI(this.rotIzq(p, p.obtenerLD()));
            } else {
                ant.asignarLD(this.rotIzq(p, p.obtenerLD()));
            }
            ;
            this.calcFB(this.obtenerRaiz());
        } else if (p.obtenerFB() == 2 && p.obtenerLI().obtenerFB() == -1 && this.evaluarHijos(p) == false) {
            var q = p.obtenerLI();
            var r = this.hijoMaxAlt(q);

            if (ant == null) {
                this.asignarRaiz(this.rotDobleDere(p, q, r));
            } else if (ant.obtenerLI() == p) {
                ant.asignarLI(this.rotDobleDere(p, q, r));
            } else {
                ant.asignarLD(this.rotDobleDere(p, q, r));
            }
            ;
            this.calcFB(this.obtenerRaiz());
        } else if (p.obtenerFB() == -2 && p.obtenerLD().obtenerFB() == 1 && this.evaluarHijos(p) == false) {
            var q = p.obtenerLD();
            var r = this.hijoMaxAlt(q);

            if (ant == null) {
                this.asignarRaiz(this.rotDobleIzq(p, q, r));
            } else if (ant.obtenerLD() == p) {
                ant.asignarLD(this.rotDobleIzq(p, q, r));
            } else {
                ant.asignarLI(this.rotDobleIzq(p, q, r));
            }
            ;
            this.calcFB(this.obtenerRaiz());
        }

        if (p.obtenerLI() != null) {
            this.rotar(p.obtenerLI(), p);
        }
        ;
        if (p.obtenerLD() != null) {
            this.rotar(p.obtenerLD(), p);
        }
        ;

    }
    ;
};

ArbolBinario.prototype.rotDer = function(p, q) {
    p.asignarLI(q.obtenerLD());
    q.asignarLD(p);

    return q;
};

ArbolBinario.prototype.rotIzq = function(p, q) {
    p.asignarLD(q.obtenerLI());
    q.asignarLI(p);

    return q;
};

ArbolBinario.prototype.rotDobleDere = function(p, q, r) {
    q.asignarLD(r.obtenerLI());
    p.asignarLI(r.obtenerLD());
    r.asignarLI(q);
    r.asignarLD(p);

    return r;
};

ArbolBinario.prototype.rotDobleIzq = function(p, q, r) {
    q.asignarLI(r.obtenerLD());
    p.asignarLD(r.obtenerLI());
    r.asignarLD(q);
    r.asignarLI(p);
    return r;
};

ArbolBinario.prototype.hijoMaxAlt = function(q) {
    var a = this.alturaArbolR(q.obtenerLI());
    var b = this.alturaArbolR(q.obtenerLD());
    if (a > b) {
        return q.obtenerLI();
    } else {
        return q.obtenerLD();
    }
    ;
};

ArbolBinario.prototype.limpiarFondo = function(can, x, y) {
    can.clearRect(x, y, 3000, 3000);
};

ArbolBinario.prototype.contarNodosDerechos = function(p) {
    var c = 0;
    if (p.obtenerLI() != null) {
        c = this.contarNodosRecursivo(p.obtenerLI());
    }
    ;
    return c;
};

ArbolBinario.prototype.contarNodosIzquierdos = function(p) {
    var c = 0;
    if (p.obtenerLD() != null) {
        c = this.contarNodosRecursivo(p.obtenerLD());
    }
    ;
    return c;
};

ArbolBinario.prototype.contarNodosRecursivo = function(p) {
    var c = 0;
    if (p != null) {
        c += this.contarNodosRecursivo(p.obtenerLI());
        c += this.contarNodosRecursivo(p.obtenerLD());
        c++;
    }
    ;
    return c;
};

ArbolBinario.prototype.evaluarFBHijos = function(p) {
    var c = false;
    if (p != null) {
        if (p.obtenerFB() == 2 || p.obtenerFB() == -2) {
            c = true;
        }
        c = c || this.evaluarFBHijos(p.obtenerLI());
        c = c || this.evaluarFBHijos(p.obtenerLD());
    }
    return c;
}

ArbolBinario.prototype.evaluarHijos = function(p) {
    var c = this.evaluarFBHijos(p.obtenerLI()) || this.evaluarFBHijos(p.obtenerLD());
    return c;
};

//Inicio
function iniciar(d) {
    arbol = new ArbolBinario();
    var canvas = document.getElementById("myCanvas");
    contexto = canvas.getContext("2d");
    for (var i = 0; i < d.length; i++) {
        arbol.insertar(d[i]);
    };
    arbol.pintar(contexto, 1500, 20);
    //arbol.limpiarFondo(contexto,3000,3000);
}

//Botones
function btnInsertar() {
    var dato = Math.floor(d1.value);
    arbol.insertar(dato);
    arbol.limpiarFondo(contexto, 0, 0);
    arbol.pintarFondoNodo(contexto, arbol.obtenerRaiz(), 1500, 20, dato);
    arbol.pintar(contexto, 1500, 20);
    setTimeout(
            function() {
                arbol.limpiarFondo(contexto, 0, 0);
                arbol.pintar(contexto, 1500, 20);
            }, 3000
            );

}

function btnBuscar() {
    var dato = Math.floor(d2.value);
    arbol.limpiarFondo(contexto, 0, 0);
    arbol.pintarFondoNodo(contexto, arbol.obtenerRaiz(), 1500, 20, dato);
    arbol.pintar(contexto, 1500, 20);
    setTimeout(
            function() {
                arbol.limpiarFondo(contexto, 0, 0);
                arbol.pintar(contexto, 1500, 20);
            }, 3000
            );
}