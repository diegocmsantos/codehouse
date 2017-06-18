<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>

<tags:pageTemplate title="Product Not Found">

	<section id="index-section" class="container middle">

		<h1 class="cdc-call">Últimos dias com os preços promocionais. Aproveite!</h1>
		<ul class="clearfix book-collection">

			<!-- Aqui você fará a repetição -->

			<section id="index-section" class="container middle">
                <h2>General error happened</h2>
            </section>

            <!--
                Message: ${exception.message}
                <c:forEach items="${exception.stackTrace}" var="stk">
                    ${stk}
                </c:forEach>
            -->
			
			<!-- Fechando aqui -->
			
		</ul>

		<h2 class="cdc-call">Diferenciais da Casa do Código</h2>

		<ul id="cdc-diferenciais" class="clearfix">
			<li class="col-left">
				<h3>E-books sem DRM. Leia onde quiser</h3>
				<p>
					<span class="sprite" id="sprite-drm"></span> Nossos e-books não
					possuem DRM, ou seja, você pode ler em qualquer computador, tablet
					e smartphone.
				</p>
			</li>
			<li class="col-right">
				<h3>Autores de renome na comunidade</h3>
				<p>
					<span class="sprite" id="sprite-renome"></span> Autores que
					participam ativamente na comunidade com Open Source, listas de
					discussão, grupos e mais.
				</p>
			</li>
			<li class="col-left">
				<h3>Receba atualizações dos e-books</h3>
				<p>
					<span class="sprite" id="sprite-atualizacoes"></span> Quando você
					compra um e-book, automaticamente tem direito às atualizações e
					correções dele.
				</p>
			</li>
			<li class="col-right">
				<h3>Livros com curadoria da Caelum</h3>
				<p>
					<span class="sprite" id="sprite-caelum"></span> Desenvolvedores
					experientes que avaliam e revisam os livros constantemente.
				</p>
			</li>
		</ul>

	</section>
	
</tags:pageTemplate>