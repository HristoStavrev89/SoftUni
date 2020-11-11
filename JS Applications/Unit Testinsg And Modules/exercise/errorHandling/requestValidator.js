function httpRequest(request) {

    let methods = ['GET', 'POST', 'DELETE', 'CONNECT'];
    if (!methods.includes(request.method)) {
        throw new Error("Invalid request header: Invalid Method");
    }

    let versionReg = /^([A-Za-z0-9.]+)$|\*/g;
    if (!request.uri.match(versionReg)) {
        throw new Error("Invalid request header: Invalid URI")
    }

    let versions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    if (!versions.includes(request.version)) {
        throw new Error("Invalid request header: Invalid Version")
    }

    let messageReg = /^([^<>\\&'"]*)$/g;
    if (!request.message.match(messageReg)) {
        throw new Error("Invalid request header: Invalid Message")
    }

    return request;
}


httpRequest({
        method: 'GET',
        uri: 'svn.public.catalog',
        version: 'HTTP/1.1',
        message: ''
    }
);