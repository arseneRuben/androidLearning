<xsl:transform xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:xs="http://www.w3.org/2001/XMLSchema" exclude-result-prefixes="xs" version="2.0">

    <xsl:template match="p">
        <xsl:copy>
            <xsl:choose>
                <xsl:when test="($teaching-assistant-paragraph-bullet = '') or ($teaching-assistant-paragraph-bullet = ' ')"></xsl:when>
                <xsl:when test="$teaching-assistant-paragraph-bullet = 'tilde'">
                    <xsl:attribute name="class">bullet-tilde</xsl:attribute>
                </xsl:when>
                <xsl:when test="$teaching-assistant-paragraph-bullet = 'arrow'">
                    <xsl:attribute name="class">bullet-arrow</xsl:attribute>
                </xsl:when>
                <xsl:otherwise>
                    <xsl:attribute name="class">bullet-diamond</xsl:attribute>
                </xsl:otherwise>
            </xsl:choose>

            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>

    <xsl:template match="table">
        <xsl:copy>
            <xsl:attribute name="class">table table-bordered w-auto</xsl:attribute>
            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>

    <xsl:template match="ul|ol">
        <xsl:copy>
            <xsl:call-template name="apply-custom-class">
                <xsl:with-param name="parameter">
                    <xsl:value-of select="$teaching-assistant-list-class" />
                </xsl:with-param>
                <xsl:with-param name="default">list-group</xsl:with-param>
            </xsl:call-template>

            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>

    <xsl:template match="li|dt|dd">
        <xsl:copy>
            <xsl:call-template name="apply-custom-class">
                <xsl:with-param name="parameter">
                    <xsl:value-of select="$teaching-assistant-list-item-class" />
                </xsl:with-param>
                <xsl:with-param name="default">list-group-item</xsl:with-param>
            </xsl:call-template>

            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>

    <xsl:template match="h2|h3|h4|h5|h6">
        <xsl:copy>
            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>

    <xsl:template match="h1">
        <xsl:copy>
            <xsl:element name="span">
                <xsl:call-template name="apply-custom-class">
                    <xsl:with-param name="parameter">
                        <xsl:value-of select="$teaching-assistant-h1-class" />
                    </xsl:with-param>
                    <xsl:with-param name="default">badge badge-secondary</xsl:with-param>
                </xsl:call-template>

                <xsl:apply-templates select="@*|node()" />
            </xsl:element>
        </xsl:copy>
    </xsl:template>

    <xsl:template match="section">
        <xsl:variable name="section-number" select="count(preceding-sibling::*[name() = name(current())]) + 2" />
        <xsl:copy>
            <xsl:attribute name="class">shadow p-3 mb-5 bg-white rounded</xsl:attribute>
            <!--
                The target should reach the section but the static navbar create ann offset.
                This div will be hidden and positionned to compensate for the navbar
            -->
            <xsl:element name="div">
                <xsl:attribute name="id">
                    <xsl:call-template name="generate-menu-id">
                        <xsl:with-param name="title">
                            <xsl:value-of select="h1/." />
                        </xsl:with-param>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:element>

            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>

    <xsl:template match="article">
        <xsl:copy>
            <xsl:variable name="h-indentation-prefix">
                <xsl:choose>
                    <xsl:when test="$teaching-assistant-h-indentation-class">
                        <xsl:value-of select="$teaching-assistant-h-indentation-class" />
                    </xsl:when>
                    <xsl:otherwise>contain</xsl:otherwise>
                </xsl:choose>
            </xsl:variable>

            <xsl:attribute name="class">
                <xsl:choose>
                    <xsl:when test="*[name()='h2']">
                        <xsl:value-of select="concat($h-indentation-prefix, '-h2')" />
                    </xsl:when>
                    <xsl:when test="*[name()='h3']">
                        <xsl:value-of select="concat($h-indentation-prefix, '-h3')" />
                    </xsl:when>
                    <xsl:when test="*[name()='h4']">
                        <xsl:value-of select="concat($h-indentation-prefix, '-h4')" />
                    </xsl:when>
                    <xsl:when test="*[name()='h5']">
                        <xsl:value-of select="concat($h-indentation-prefix, '-h5')" />
                    </xsl:when>
                    <xsl:when test="*[name()='h6']">
                        <xsl:value-of select="concat($h-indentation-prefix, '-h6')" />
                    </xsl:when>
                </xsl:choose>
            </xsl:attribute>

            <!--
                The target should reach the section but the static navbar create ann offset.
                This div will be hidden and positionned to compensate for the navbar
            -->
            <xsl:element name="div">
                <xsl:attribute name="id">
                    <xsl:call-template name="generate-menu-id">
                        <xsl:with-param name="title">
                            <xsl:value-of select="*[1]/." />
                        </xsl:with-param>
                    </xsl:call-template>
                </xsl:attribute>
            </xsl:element>

            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>

    <xsl:template match="pre[ code ]">
        <xsl:variable name="generatedId" select="generate-id()" />
        <div class="card">
            <div class="card-body">
                <xsl:if test="code/@data-title">
                    <h5 class="card-title">
                        <xsl:value-of select="code/@data-title" />
                    </h5>
                </xsl:if>
                <xsl:if test="code/@data-subtitle">
                    <h6 class="card-subtitle mb-2 text-muted">
                        <xsl:value-of select="code/@data-subtitle" />
                    </h6>
                </xsl:if>
                <xsl:copy>
                    <xsl:attribute name="id">
                        <xsl:value-of select="concat('code_snippet_', $generatedId)" />
                    </xsl:attribute>
                    <xsl:copy-of select="./code" />
                </xsl:copy>

                <button class="copy-button btn btn-light noprint" data-clipboard-target="#code_snippet_{$generatedId}">
                    <xsl:value-of select="$lang//labels/copy" />
                </button>
            </div>
        </div>
    </xsl:template>

    <xsl:template match="img">
        <div class="card">
            <div class="card-body">
                <xsl:if test="@data-title">
                    <h5 class="card-title">
                        <xsl:value-of select="@data-title" />
                    </h5>
                </xsl:if>
                <xsl:if test="@data-subtitle">
                    <h6 class="card-subtitle mb-2 text-muted">
                        <xsl:value-of select="@data-subtitle" />
                    </h6>
                </xsl:if>
                <div class="card-body-img">
                    <xsl:copy-of select="." />
                </div>
            </div>
        </div>
    </xsl:template>

    <xsl:template match="a">
        <xsl:copy>
            <xsl:attribute name="target">_blank</xsl:attribute>
            <xsl:apply-templates select="@*|node()" />
        </xsl:copy>
    </xsl:template>

    <xsl:template name="generate-menu-id">
        <xsl:param name="title" />

        <xsl:variable name="lowercase" select="'abcdefghijklmnopqrstuvwxyz'" />
        <xsl:variable name="uppercase" select="'ABCDEFGHIJKLMNOPQRSTUVWXYZ'" />
        <xsl:variable name="space" select="' '" />
        <xsl:variable name="underscore" select="'_'" />
        <xsl:variable name="accent" select="'áàâäéèêëíìîïóòôöúùûüÁÀÂÄÉÈÊËÍÌÎÏÓÒÔÖÚÙÛÜ'" />
        <xsl:variable name="no_accent" select="'aaaaeeeeiiiioooouuuuAAAAEEEEIIIIOOOOUUUU'" />

        <xsl:value-of select="concat('id_', translate(translate(translate($title, $accent, $no_accent), $space, $underscore), $uppercase, $lowercase))" />
    </xsl:template>
</xsl:transform>