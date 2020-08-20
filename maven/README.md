## Benefits of local repository of maven
<ul>
<li>A single reference repository (maybe at organization level) of all dependent software libraries rather than several independent local libraries</li>
<li>Faster to do a clean build when using an internal repository as Maven artifacts are retrieved localy from same machine or from a server on the intranet (LAN)</li>
<li>Faster loading while the first build</li>
<li>Reduced likelihood of version conflicts</li>
</ul>



