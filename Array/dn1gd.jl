
using LinearAlgebra
using SparseArrays

function dn1gd(y::AbstractVector;x0::AbstractVector = y,reg::Number = 1,del::Number = 2, niter::Number=100)
    n = size(y,1);
    S1 = spdiagm(0 => 1:1:n-1, 1 =>2:1:n);
    S2 = spdiagm(0 => 2:1:n, 1 =>1:1:n-1);
    S3 = S1 .- S2;
    S4 = S3[1:n-1,:];
    
    S5 = spdiagm(0 => 2:1:n+1, -1 => 1:1:n-1);
    S6 = spdiagm(0 => 1:1:n, -1 => 2:1:n);
    S7 = S6.-S5;
    S7= S7[:,1:n-1];
    
    cost(x) = (1/2)*norm(y.-x)^2 + reg*sum(del^2*(abs.(S4*x)./del .- log.(abs.(S4*x)./del .+ 1)));
    gg(x)=reg*del^2*((S4*x)./(del.+abs.(S4*x)));
    grad(x) = S7*gg(x).+x.-y;
    L = 1 + 3*reg*del;
    thecost = zeros(niter+1);
    x = x0;
    thecost[1] = cost(x);
    for i = 1:niter
        x = x .- (1/L)*grad(x);
        thecost[1+i] = cost(x);
    end
    return x, thecost
end     
